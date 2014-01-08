# jsonDoclet

A Javadoc Doclet that generates JSON from your Javadocs.

## Usage

1. Download the [standalone release](https://github.com/tantaman/jsonDoclet/blob/release/jsonDoclet-0.1.0-SNAPSHOT-standalone.jar) (includes all dependencies)
2. run the doclet with javadoc:
  ```bash

    javadoc \
      -doclet com.tantaman.doc.JsonDoclet \
      -docletpath path/to/jsonDoclet.jar \
      -sourcepath path/to/your/java/src \
      -subpackages your-root-package
  ```


Output will be placed into the `./docs` directory relative to where you ran `javadoc`.  It creates one `.json` file per class.

See [Oracle's docs](http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html#runningjavadoc) for more information on how to run `javadoc` from the command line.

## License

Copyright © 2014 Matt Crinklaw

Distributed under the Eclipse Public License, the same as Clojure.
