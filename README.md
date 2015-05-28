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
3. See **each** translation files present in  a specific folder, and simply open them with a double click.



### Known issues

1. Some xml tags are not yet implemented, making file load rise an exception.
2. The Constructor / Methods / Properties blocks grow as if each element was below the precedent, which is actually not the case.



### License

Copyright 2015 **Mathieu Blond - Ijinus** ( mathieu.blond@ijinus.fr )

CS2JXmlEditor is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CS2JXmlEditor is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with CS2JXmlEditor.  If not, see <http://www.gnu.org/licenses/>.
