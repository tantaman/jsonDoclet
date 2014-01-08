(ns com.tantaman.doc.JsonDoclet
  (:require [clojure.data.json :as json])
  (:gen-class 
    :methods [#^{:static true} [start [com.sun.javadoc.RootDoc] boolean]]))

(def dir "./docs")
(.mkdirs (java.io.File. dir))

(defn write-class [docmap]
  (spit (str dir "/" (docmap "qualifiedName") ".json") (json/write-str docmap)))

(declare extract-docs)
(def doc-keys 
  {
   "name" #(.name %)
   "annotations" #(map extract-docs (.annotations %))
   "qualifiedName" #(.qualifiedName %)
   "methods" #(map extract-docs (.methods %))
   "docString" #(.commentText %)
   "fields" #(map extract-docs (.fields %))
   "interfaces" #(map extract-docs (.interfaceTypes %))
   "innerClasses" #(map extract-docs (.innerClasses %))
   "constructors" #(map extract-docs (.constructors %))
   "parameters" #(map extract-docs (.parameters %))
   "typeName" #(.typeName (.type %))
   "qualifiedTypeName" #(.qualifiedTypeName (.type %))
   "modifiers" #(.modifiers %)
   "returnType" #(.qualifiedTypeName (.returnType %))
   "annotationType" #(.qualifiedTypeName (.annotationType %))
   "elementValues" #(map extract-docs (.elementValues %))
   "element" #(extract-docs (.element %))
  })

(defn extract-docs [doc-obj]
  (reduce-kv
    (fn [docmap k extractor] 
      (try 
        (assoc docmap k (extractor doc-obj))
        (catch Exception e docmap)))
   {} doc-keys))

(defn start [root]
  (doall (pmap write-class (map extract-docs (.classes root))))
  true)

(defn -start [root]
  (start root))
