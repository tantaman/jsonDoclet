(defproject jsonDoclet "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths [~(str (System/getenv "JAVA_HOME") "/lib/tools.jar")] ;
  :aot [com.tantaman.doc.JsonDoclet]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.json "0.2.3"]])
