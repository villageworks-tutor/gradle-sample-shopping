package sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sample.bean.Category;

public class CategoryDAO {
	
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
	public CategoryDAO() throws DAOException {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの読み込みに失敗しました。");
		}
	}

	/**
	 * すべてのカテゴリを取得する
	 * @return カテゴリリスト（テーブルにレコードがない場合には空リスト）
	 * @throws DAOException 
	 */
	public List<Category> findAll() throws DAOException {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASWORD);
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM categories ORDER BY id");
			 ResultSet rs = pstmt.executeQuery();
			) {
			// カテゴリリストを初期化
			List<Category> list = new ArrayList<Category>();
			while (rs.next()) {
				list.add(convertToBean(rs));
			}
			// カテゴリリストの返却
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
	/**
	 * 結果セットのレコードからBeanに変換する
	 * @param rs
	 * @return 1レコード分のカテゴリインスタンス
	 * @throws SQLException
	 */
	private Category convertToBean(ResultSet rs) throws SQLException {
		Category bean = new Category();
		bean.setId(rs.getInt("id"));
		bean.setName(rs.getString("name"));
		return bean;
	}
	

}
