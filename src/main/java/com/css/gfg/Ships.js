// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(N, S, T) {
    var matrix = createArray(N) ;
    var Tarray =  T.split(" ");
    var Sarray =  S.split(",");
    var sCount = 0;
    var hCount = 0;

  // console.log(matrix);    
    for(var i= 0; i < Tarray.length ; i++) {
        var at = Tarray[i].split('');
        var r = parseInt(at[0]) - 1;
        var c = at[1].charCodeAt() - 65;
        matrix[r][c] = 1;
    }
    
  //  console.log(matrix);    
    for(var i = 0; i< Sarray.length ; i++) {
        var temp = Sarray[i].split(' ');
//	console.log(temp);
        var f = temp[0].split('');
        var s = temp[1].split('');

        var r1 = parseInt(f[0])-1;
        var r2 = parseInt(s[0])-1;

//	console.log(f);        
        var c1 = f[1].charCodeAt() - 65;
        var c2 = s[1].charCodeAt() - 65;

//        console.log(r1 + ":" + r2 + ":" + c1 + ":" + c2);
        
        if (r1 == r2 && c1 == c2) {
            sCount += matrix[r1][c1];
        } else if (r1 == r2) {
            var chCount = 0;
            for (var l = c1; l <= c2; l++) {
                chCount += matrix[r1][l];
            }
            
            if (chCount-1 == c2-c1)
              sCount++;
            else if (chCount != 0)
               hCount++;

//            console.log(r1 + ":" + r2 + ":" + c1 + ":" + c2);
//	console.log(chCount);
            
        } else if (c1 == c2) {
             var chCount = 0;
            for (var l = r1; l <= r2; l++) {
                chCount += matrix[l][c1];
            }
            
            if (chCount-1 == r2-r1)
              sCount++;
            else if (chCount != 0)
               hCount++;

  //      console.log(sCount + ", " + hCount);
//	console.log(chCount);

  //          console.log(r1 + ":" + r2 + ":" + c1 + ":" + c2);
        } else {

        //    console.log(r1 + ":" + r2 + ":" + c1 + ":" + c2);
            var chCount = 0;
            chCount += matrix[r1][c1];
            chCount += matrix[r1][c2];
            chCount += matrix[r2][c1];
            chCount += matrix[r2][c2];
             if (chCount == 4)
              sCount++;
            else if (chCount != 0)
               hCount++;

//	console.log(chCount);
  //      console.log(sCount + ", " + hCount);
	
        }
                    
    }
    console.log(sCount + ", " + hCount);
    
}

function createArray(N) {
  var a = new Array();

   for (i=0;i<N;i++) {
	 a[i]=new Array();
	 for (j=0;j<N;j++) {
		  a[i][j]=0;
     }
  }
  return a;
}


solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
