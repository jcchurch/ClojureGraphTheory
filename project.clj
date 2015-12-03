(defproject graphtheory "0.1.0-SNAPSHOT"
  :description "Graph Theory Algorithms"
  :url "http://github.com/jcchurch/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot graphtheory.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
