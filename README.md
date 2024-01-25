# WordFall-Game
A game where letters keep falling and you have to try to move the ball using w, a, s, d to collect those letters and click enter when you collect a word. You get a certain amount of points per word and 60 seconds to collect as much as you can.


Uses Canvas for the GUI -->   https://docs.oracle.com/javase/8/docs/api/java/awt/Canvas.html
uses WordHelper to make sure a word collected is a real word  
  how it works:
      0 - Not a word and cannot be a word with additions (e.g. "SX")
      1 - Not a word, but could be with  additions (e.g. "WRI")
      2 - Is a word, and could also add letters (e.g. "THE")
      3 - Is a word, but will not be if any letters added (e.g. "FURIOUSLY")

