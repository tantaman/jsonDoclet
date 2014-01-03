# jsonDoclet

A Javadoc Doclet that generates JSON from your Javadocs.

## Usage

1. clone this repo
2. compile: `lein compile`
3. run the doclet with javadoc:
  `javadoc -doclet com.tantaman.doc.JsonDoclet -docletpath path/to/jsondoclet/target/classes path/to/your/java/src`

  (make sure clojure-1.5.1.jar is on your classpath)

Your json docs will be placed into the "./docs" directory relative to where you ran `javadoc`.

## License

Copyright © 2014 Matt Crinklaw

Distributed under the Eclipse Public License, the same as Clojure.
