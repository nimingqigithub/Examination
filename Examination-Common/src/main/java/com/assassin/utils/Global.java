package com.assassin.utils;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 全局配置类
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader(
			"config.properties");

	/**
	 * 数据库类型：h2
	 */
	public static final String DATABASE_TYPE_H2 = "h2";

	/**
	 * 数据库类型：mysql
	 */
	public static final String DATABASE_TYPE_MYSQL = "mysql";

	/**
	 * 数据库类型：oracle
	 */
	public static final String DATABASE_TYPE_ORACLE = "oracle";

	/**
	 * 数据库类型：postgres
	 */
	public static final String DATABASE_TYPE_POSTGRES = "postgres";

	/**
	 * 数据库类型：mssql
	 */
	public static final String DATABASE_TYPE_MSSQL = "mssql";

	/**
	 * 数据库类型：db2
	 */
	public static final String DATABASE_TYPE_DB2 = "db2";

	/**
	 * 获取当前对象实例
	 * 
	 * @return Global实例
	 */
	public static Global getInstance() {
		return global;
	}

	/**
	 * 获取配置
	 * 
	 * @param key
	 * @return 属性值
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = propertiesLoader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 * 
	 * @return true/false
	 */
	@Deprecated
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equalsIgnoreCase(dm);
	}

}
