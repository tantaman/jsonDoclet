(ns com.tantaman.doc.JsonDoclet
  (:require [clojure.data.json :as json])
  (:gen-class 
    :methods [#^{:static true} [start [com.sun.javadoc.RootDoc] boolean]]))

(def dir "./docs")

(defn write-class [docmap]
  (spit (str dir "/" (docmap "qualifiedName")) (json/write-str docmap)))

(declare extract-docs)
(def doc-keys 
  {
   "name" #(.name %)
   "annotations" #(map extract-docs (.annotations %))
   "qualifiedName" #(.qualifiedName %)
   "methods" #(map extract-docs (.methods %))
   "docString" #(.commentText %)
   "fields" #(map extract-docs (.fields %))
   "interfaces" #(map extract-docs (.interfaces %))
  })

(defn extract-docs [doc-obj]
  (reduce-kv
    (fn [docmap k extractor] 
      (try 
        (assoc docmap k (extractor doc-obj))
        (catch Exception e docmap)))
   {} doc-keys))

(defn -start [root]
  (pmap write-class (map extract-docs (.classes root)))
  true)
