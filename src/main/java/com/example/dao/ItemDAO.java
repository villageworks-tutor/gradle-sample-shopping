package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.Category;

public class ItemDAO {
	/**
	 * クラス定数軍：データベース接続情報文字列定数
	 * TODO: この定数群はプロパティファイルに切り出すこと
	 */
	protected static final String JDBC_DRIVER = "org.postgresql.Driver";
	protected static final String DB_URL = "jdbc:postgresql:spring_sample";
	protected static final String DB_USER = "student";
	protected static final String DB_PASWORD = "himitu";
	
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

	public List<Category> findAllCategory() throws DAOException {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASWORD);
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM categories ORDER BY id");
			 ResultSet rs = pstmt.executeQuery();
			) {
			
			// 結果セットからカテゴリリストに変換
			List<Category> list = new ArrayList<Category>();
			while (rs.next()) {
				Category bean = new Category();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				list.add(bean);
			}
			
			// カテゴリリストを返却
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

}
