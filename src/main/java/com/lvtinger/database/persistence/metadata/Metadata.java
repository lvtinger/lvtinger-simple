package com.lvtinger.database.persistence.metadata;

import java.util.List;
import com.lvtinger.database.persistence.annotation.ShardMode;

public class Metadata {
    private ShardMode mode;
    private List<Property> properties;
}
