package com.feiwang.freedom.hbase;

public class HBaseReader {
    public static Configuration conf;

    static {
        //使用 HBaseConfiguration 的单例方法实例化
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "hadoop02");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
    }

    public static boolean isTableExist(String tableName)
            throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
        //在 HBase 中管理、访问表需要先创建 HBaseAdmin 对象
        // Connection connection = ConnectionFactory.createConnection(conf);
        // HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();

        HBaseAdmin admin = new HBaseAdmin(conf);
        return admin.tableExists(tableName);
    }

}
