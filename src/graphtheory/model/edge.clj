(ns graphtheory.model.edge
  "Library for the creation of edges based on vertices."
)
(require '[graphtheory.model.vertex :as vertex])

(defn make
  "Make a new edge"
  [vertexa vertexb weight]
  (if (and (vertex/is vertexa) (vertex/is vertexb))
      {:first vertexa, :second vertexb, :weight weight, :type :edge}
      :fail
  )
)

(defn is
  "Is this an edge?"
  [edge]
  (= :edge (edge :type))
)

(defn contains
  "Given an edge and a vertex, returns true if vertex is in edge and false otherwise."
  [edge vertexa]
  (if (and (is edge) (vertex/is vertexa))
     (or (= vertexa (edge :first))
         (= vertexa (edge :second))
     )
     :fail
  )
) 

(defn getOtherVertex
  "Given an edge and a vertex, gets the opposite vertex."
  [edge vertexa]
  (if (and (is edge)
           (vertex/is vertexa)
           (= true (contains edge vertexa))
      )
      (if (= vertexa (edge :first))
          (edge :second)
          (edge :first)
      )
      :fail
  )
)

(defn firstName
  "Given an edge, returns the first name"
  [edge]
  (if (is edge)
    ((edge :first) :name)
    :fail
  )
)

(defn secondName
  "Given an edge, returns the second name"
  [edge]
  (if (is edge)
    ((edge :second) :name)
    :fail
  )
)
