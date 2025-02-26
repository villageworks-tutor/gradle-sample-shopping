package sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sample.bean.Item;

public class ItemDAO {

	/**
	 * クラス定数軍：データベース接続情報文字列定数
	 * TODO: この定数群はプロパティファイルに切り出すこと
	 */
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql:spring_sample";
	private static final String DB_USER = "student";
	private static final String DB_PASWORD = "himitu";
	
	/**
	 * コンストラクタ
	 * @throws DAOException
	 */
	public ItemDAO() throws DAOException {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの読み込みに失敗しました。");
		}
	}

	/**
	 * すべての商品を取得する
	 * @return 商品リスト（テーブルにレコードがない場合には空リスト）
	 * @throws DAOException
	 */
	public List<Item> findAll() throws DAOException {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASWORD);
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM items ORDER BY id");
			 ResultSet rs = pstmt.executeQuery();
			) {
			// 結果リストから商品リストへの入替え
			List<Item> list = new ArrayList<Item>();
			while (rs.next()) {
				Item bean = convertToBean(rs);
				list.add(bean);
			}
			// 商品リストを返却
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	/**
	 * 結果セットのレコードからBeanに変換する
	 * @param rs
	 * @return 1レコード分の商品インスタンス
	 * @throws SQLException
	 */
	private Item convertToBean(ResultSet rs) throws SQLException {
		Item bean = new Item();
		bean.setId(rs.getInt("id"));
		bean.setCategoryId(rs.getInt("category_id"));
		bean.setName(rs.getString("name"));
		bean.setPrice(rs.getInt("price"));
		return bean;
	}

	/**
	 * 指定された商品カテゴリに含まれる商品を取得する
	 * @param categoryId 対象カテゴリ
	 * @return 商品カテゴリに含まれる商品リスト（該当商品がない場合には空リスト）
	 * @throws DAOException
	 */
	public List<Item> findByCategoryId(int categoryId) throws DAOException {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASWORD);
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM items WHERE category_id = ? ORDER BY id");
			) {
			// プレースホルダにパラメータを設定
			pstmt.setInt(1, categoryId);
			// SQLの実行と結果セットの取得
			List<Item> list = new ArrayList<Item>();
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					list.add(convertToBean(rs));
				}
			}
			// 商品リストの返却
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
}
