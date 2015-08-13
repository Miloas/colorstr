# colorstr

A Clojure library to stylized string in console using ANSI escape code.

## Usage

```clojure
;For leiningen,add to your require
[colorstr "0.1.0"]
```
## Example

```clojure
-> (println (style "Its red" :red))
=> "Its red" ;text color is red

-> (println (style "Its bright and red,backgroud is blue" :red :bright :bg-blue))
```

```clojure
;All style you can select.
  {:strikethrough-off  
   :strikethrough     
   :inverse-off      
   :inverse         
   :underline-off      
   :underline         
   :blink-slow       
   :bright          
   :reset              

   :default            
   :white              
   :black              
   :red                
   :green              
   :blue               
   :yellow             
   :megenta            
   :cyan               

   :bg-default         
   :bg-white           
   :bg-black          
   :bg-red            
   :bg-green           
   :bg-blue            
   :bg-yellow          
   :bg-megenta         
   :bg-cyan            
  }
```

## Tips

```clojure
;same class will be cover

-> (style "red" :blue :red)
;Same as (syle "red" :red)

```
## License

MIT.
