# What is this?

This is a demo application demonstrating a scheduled job issue with JobRunr.

# Setup

## Create the database

```
$ psql postgres
# CREATE ROLE jobrunr_scheduled_demo WITH LOGIN PASSWORD 'example123' CREATEDB;
# \q
$ psql postgres -U jobrunr_scheduled_demo
> CREATE DATABASE jobrunr_scheduled_demo;
> GRANT ALL PRIVILEGES ON DATABASE jobrunr_scheduled_demo TO jobrunr_scheduled_demo;
> \q
```

## Run part 1

From this directory, run part 1, and just Ctrl+C to stop it after it has fully started:

```
$ (cd demo-part-1 && ./mvnw spring-boot:run)
```

This should initialize the application with JobRunr 4.0.7, running the JobRunr migrations.

## Run part 2

From this directory, run the demo and watch the log:

```
$ (cd demo-part-2 && ./mvnw spring-boot:run)
```

This project will trigger a scheduled job, which fails to insert, ultimately causing JobRunr to shut down.

NOTE: The error won't happen until JobRunr attempts to schedule the job, so once starting the process, wait a couple minutes to see the exception show up.

## Extra

If you were to run part 2 from a fresh database, everything works, so it seems the migration order is the root cause of the issue.
