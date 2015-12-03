(ns graphtheory.model.kruskal
  "Computes the minimum spanning tree of a graph using Kruskal"
)
(require '[graphtheory.model.graph :as graph])
(require '[graphtheory.model.edge :as edge])
(require 'clojure.set)

(defn make-sets
  "Given a list of vertices, put each vertex into a unique set."
  [vertices]
  (zipmap vertices (range (count vertices)))
)

(defn order-edges-by-weight
  "Given a list of edges, orders them by weight."
  [edges]
  (sort-by (fn [[_,_,weight]] weight) edges)
)

(defn in-same-set
  "Given an edge and the setlist, determines if the two vertices are in the same set list"
  [[fst,snd,_] setlist]
  (= (setlist fst) (setlist snd))
)

(defn merge-vertices-into-set 
  "Given an edge and the setlist, merges the two vertices into the same set."
  [[fst,snd,_] setlist]
  (conj setlist
        (zipmap 
          (map first
               (filter
                 (fn [n] (== (setlist fst) (second n)))
                 setlist
               )
          ) 
          (repeat (setlist snd))
        )
  )
)

(defn evaluate-edges-into-tree
  "Given a list of edges ordered by increasing weight and a setlist, recursively evaluates each edge."
  [edges setlist]
  (if (= 0 (count edges))
    '()
    (if (in-same-set (first edges) setlist)
      (evaluate-edges-into-tree (rest edges) setlist)
      (conj (evaluate-edges-into-tree
             (rest edges)
             (merge-vertices-into-set (first edges) setlist)
            ) 
            (first edges)
      )
    )
  )
)

(defn kruskal
  "Given a graph, computes the minimum spanning tree using Kruskal"
  [graph]
  (if (graph/is graph)
    {:type :graph,
     :vertices (graph :vertices),
     :edges (evaluate-edges-into-tree
              (order-edges-by-weight (graph :edges)) 
              (make-sets (graph :vertices))
            )
    }
    :fail
  )
) 
