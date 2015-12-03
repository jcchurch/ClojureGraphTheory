(ns graphtheory.vertex-test)
(require '[clojure.test :refer :all])
(require '[graphtheory.model.vertex :as vertex])

(deftest VertexAisIdenticalToVertexA
  (testing "Two identical vertices should be equal"
    (is (= (vertex/make "a") (vertex/make "a")))
  )
)

(deftest VertexAisDifferentFromVertexB
  (testing "Two identical vertices should be equal"
    (is (not= (vertex/make "a") (vertex/make "b")))
  )
)
