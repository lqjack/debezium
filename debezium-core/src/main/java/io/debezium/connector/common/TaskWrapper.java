package io.debezium.connector.common;

import java.io.Serializable;
import java.util.Map;

public interface TaskWrapper extends Serializable {

    String version();

    /**
     * Start the Task
     * @param props initial configuration
     */
    void start(Map<String, String> props);

    /**
     * Stop this task.
     */
    void stop();
}
