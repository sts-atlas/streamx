package com.qubole.streamx.s3;

import io.confluent.connect.hdfs.HdfsSinkConnectorConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class S3SinkConnectorConfig extends HdfsSinkConnectorConfig {

    public static final String WAL_CLASS_CONFIG = "wal.class";
    private static final String WAL_CLASS_DOC =
            "WAL implementation to use. Use RDSWAL if you need exactly once guarantee (applies for s3)";
    public static final String WAL_CLASS_DEFAULT = "com.qubole.streamx.s3.wal.DBWAL";
    private static final String WAL_CLASS_DISPLAY = "WAL Class";

    public static final String DB_CONNECTION_URL_CONFIG = "db.connection.url";
    private static final String DB_CONNECTION_URL_DOC =
            "JDBC Connection URL. Required when using DBWAL (which is the default WAL implementation for S3)";
    public static final String DB_CONNECTION_URL_DEFAULT = "";
    private static final String DB_CONNECTION_URL_DISPLAY = "JDBC Connection URL";

    public static final String DB_USER_CONFIG = "db.user";
    private static final String DB_USER_DOC =
            "Name of the User that has access to the database. Required when using DBWAL (which is the default WAL implementation for S3)";
    public static final String DB_USER_DEFAULT = "";
    private static final String DB_USER_DISPLAY = "DB User";

    public static final String DB_PASSWORD_CONFIG = "db.password";
    private static final String DB_PASSWORD_DOC =
            "Password of the user specificed using db.user. Required when using DBWAL (which is the default WAL implementation for S3)";
    public static final String DB_PASSWORD_DEFAULT = "";
    private static final String DB_PASSWORD_DISPLAY = "DB Password";

    public static final String WAL_GROUP = "DBWAL";


    static {
        config.define(WAL_CLASS_CONFIG, ConfigDef.Type.STRING, WAL_CLASS_DEFAULT, ConfigDef.Importance.LOW, WAL_CLASS_DOC, WAL_GROUP, 1, ConfigDef.Width.MEDIUM, WAL_CLASS_DISPLAY);
        config.define(DB_CONNECTION_URL_CONFIG, ConfigDef.Type.STRING, DB_CONNECTION_URL_DEFAULT, ConfigDef.Importance.LOW, DB_CONNECTION_URL_DOC, WAL_GROUP, 1, ConfigDef.Width.MEDIUM, DB_CONNECTION_URL_DISPLAY);
        config.define(DB_USER_CONFIG, ConfigDef.Type.STRING, DB_USER_DEFAULT, ConfigDef.Importance.LOW, DB_USER_DOC, WAL_GROUP, 1, ConfigDef.Width.MEDIUM, DB_USER_DISPLAY);
        config.define(DB_PASSWORD_CONFIG, ConfigDef.Type.STRING, DB_PASSWORD_DEFAULT, ConfigDef.Importance.LOW, DB_PASSWORD_DOC, WAL_GROUP, 1, ConfigDef.Width.MEDIUM, DB_PASSWORD_DISPLAY);
    }


    public S3SinkConnectorConfig(Map<String, String> props) {
        super(props);
    }

}
