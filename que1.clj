
(ns java-interop-example
  (:import [java.util ArrayList HashMap]))

(println "Absolute value:" (Math/abs -216))
(println "Square root:" (Math/sqrt 216))
(println "Current time:" (System/currentTimeMillis))

(def java-list (new ArrayList))
(def java-map (new HashMap))

(.add java-list "Book")
(.add java-list "Phone")
(.add java-list "Tablet")

(println "Java ArrayList:" java-list)
(println "List size:" (.size java-list))

(.put java-map "Name" "Yuvraj")
(.put java-map "Age" 25)
(.put java-map "City" "Guwahati")

(println "Java HashMap:" java-map)
(println "Name:" (.get java-map "Name"))

(def clojure-vector [17 40 33 42])
(def java-array-list
  (java.util.ArrayList. clojure-vector))

(println "Java collection:" java-array-list)

(def converted-vector
  (vec java-array-list))

(println "Clojure vector:" converted-vector)

(def clojure-map {:name "Amit" :age 25})
(def converted-map
  (java.util.HashMap. clojure-map))

(def result-map
  (into {} converted-map))

(println "Converted Clojure map:" result-map)
