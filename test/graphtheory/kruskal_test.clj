(ns graphtheory.kruskal-test)
(require '[clojure.test :refer :all])
(require '[graphtheory.model.vertex :as vertex])
(require '[graphtheory.model.edge :as edge])
(require '[graphtheory.model.graph :as graph])
(require '[graphtheory.model.kruskal :as kruskal])

(def aVertex (vertex/make "a"))
(def bVertex (vertex/make "b"))
(def cVertex (vertex/make "c"))

(def abEdge (edge/make aVertex bVertex 4))
(def bcEdge (edge/make bVertex cVertex 5))
(def acEdge (edge/make aVertex cVertex 6))

(def aGraph (graph/make [abEdge bcEdge acEdge]))

(deftest AfterKruskal-aGraphIsGraph
  (testing "Kruskal of aGraph is a graph"
    (is (graph/is (kruskal/kruskal aGraph)))
  )
)

(deftest AfterKruskal-aGraphEdgeSumIs9
  (testing "Kruskal of aGraph has edge sum of 9"
    (is (= 9 (graph/edge-sum (kruskal/kruskal aGraph))))
  )
)

