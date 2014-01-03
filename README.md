# jsonDoclet

A Javadoc Doclet that generates JSON from your Javadocs.

## Usage

1. clone this repo
2. compile: `lein compile`
3. run the doclet with javadoc:
  ```bash
    javadoc \
      -doclet com.tantaman.doc.JsonDoclet \
      -docletpath path/to/jsonDoclet/target/classes \
      -sourcepath path/to/your/java/src \
      -subpackages root_package
  ```

  (make sure clojure-1.5.1.jar is on your classpath)

Output will be placed into the `./docs` directory relative to where you ran `javadoc`.  It creates one `.json` file per class.

See [Oracle's docs](http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html#runningjavadoc) for more information on how to run `javadoc` from the command line.

## License

Copyright © 2014 Matt Crinklaw

Distributed under the Eclipse Public License, the same as Clojure.
