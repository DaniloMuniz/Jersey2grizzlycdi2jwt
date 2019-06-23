/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.dao.factory;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author washington-muniz
 */
public enum Database implements IConnectionDatabase {

    MYSQL("mysql") {
        @Override
        public Optional<Connection> connection(InformationDatabase informationDatabase) {
            return new MysqlConnectionDatabase().connection(informationDatabase);
        }

        @Override
        public Optional<Connection> connectionPool(InformationDatabase informationDatabase) {
            return new PostgresqlConnectionDatabase().connection(informationDatabase);
        }
    },
    POSTGRES("postgres") {
        @Override
        public Optional<Connection> connection(InformationDatabase informationDatabase) {
            return new MysqlConnectionDatabase().connectionPool(informationDatabase);
        }

        @Override
        public Optional<Connection> connectionPool(InformationDatabase informationDatabase) {
            return new PostgresqlConnectionDatabase().connectionPool(informationDatabase);
        }
    };

    private String value;

    private static final Map<String, Database> ENUM_MAP;

    private Database(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static {
        Map<String, Database> map = new LinkedHashMap<>();
        for (Database instance : Database.values()) {
            map.put(instance.getValue(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Database from(String value) {
        return ENUM_MAP.get(value);
    }

}
