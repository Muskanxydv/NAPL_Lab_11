
(ns exception-handling)

(defn check-age [age]
  (if (< age 18)
    (throw (ex-info "Age must be 18 or above"
                    {:age age
                     :type :invalid-age}))
    (println "Eligible to vote")))

(println "\nARITHMETIC EXCEPTION")
(try
  (println "Result:" (/ 10 0))
  (catch ArithmeticException e
    (println "Caught Exception:" (.getMessage e))
    (println "Graceful Recovery: Cannot divide by zero"))
  (finally
    (println "Arithmetic operation completed")))

(println "\nNULL POINTER EXCEPTION")
(try
  (let [value nil]
    (.toUpperCase value))
  (catch NullPointerException e
    (println "Caught Exception:" (.getMessage e))
    (println "Graceful Recovery: Value is nil"))
  (finally
    (println "Null pointer check completed")))

(println "\nCUSTOM EXCEPTION")
(try
  (check-age 17)
  (catch clojure.lang.ExceptionInfo e
    (println "Caught Custom Exception:" (ex-message e))
    (println "Exception Data:" (ex-data e))
    (println "Graceful Recovery: Please enter a valid age"))
  (finally
    (println "Age validation completed")))
