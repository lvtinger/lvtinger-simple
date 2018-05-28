package com.lvtinger.database.repository;

public interface RepositoryGenerator {
    Class generate(Class repository, Class persistentObject);
}