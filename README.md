# CS2JXmlEditor

This software is an editor for [CS2J](https://github.com/MathieuBlond-Ijinus/cs2j "CS2J : A C# to Java converter")'s translations files. It provides a very simple interface to deal the simpliest way with CS2J's XMLs.

### Features

1. **Create** / **Open** / **Save** translation files.
2. **Edit** translation files
  * C# name
  * Java name
  * Boxed Java Name
  * Add / Remove / Edit :
    * Constructors
    * Methods
    * Properties

### Known issues

1. Some xml tags are not yet implemented, making file load rise an exception.
2. The Constructor / Methods / Properties blocks grow as if each element was below the precedent, which is actually not the case.
