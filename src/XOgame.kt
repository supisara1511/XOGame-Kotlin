fun main() {
    val oxArray : Array<Array<String>> = arrayOf(
        arrayOf("-","-","-"),
        arrayOf("-","-","-"),
        arrayOf("-","-","-")
    )
    var turn : String = "X"
    var row : Int
    var col : Int
    var count : Int = 1
    printArray(oxArray)

    while (true) {
        if(count > 9){
            print("Draw")
            break
        }

        println("Round : ${count} | Turn : ${turn}")
        print("Please input Row Col : ")
        val input : String? = readLine()
        val rcList  : List<String>? = input?.split(" ")
        if(rcList?.size != 2){
            println("* * * Pepeat! * * *")
            continue
        }else{
            row  = rcList?.get(0).toInt()-1
            col = rcList?.get(1).toInt()-1
        }


        if(!inputCheck(row,col)){
            println("Error : ArrayIndexOutOfBound")
            continue
        }else if(!arrayisEmpty(oxArray[row][col])){
            println("Error : Already to used")
            continue
        }else{
            oxArray[row][col] = turn
            printArray(oxArray)
            if(checkVertical(oxArray,row,turn) || checkHorizontal(oxArray,col,turn) || checkDiaonal(oxArray,turn)){
                print("${turn} win")
                break
            }

        }
        if(turn == "X") {
            turn = "O"
        }else{
            turn = "X"
        }
        count++
    }
}


fun checkVertical(arrayOX : Array<Array<String>>, row : Int,turn : String ) : Boolean{
    for(i in arrayOX[row].indices){
        if(arrayOX[row][i] != turn){
            return false
        }
    }
    return true
}

fun checkHorizontal(arrayOX : Array<Array<String>>, col : Int ,turn : String ) : Boolean{
    for(i in arrayOX.indices){
        if(arrayOX[i][col] != turn){
            return false
        }
    }
    return true
}
fun checkDiaonal(arrayOX : Array<Array<String>>,turn : String ) : Boolean{
    if(arrayOX[0][0] == turn && arrayOX[1][1] == turn  && arrayOX[2][2] == turn){
        return true
    }
    if(arrayOX[2][0] == turn && arrayOX[1][1] == turn  && arrayOX[0][2] == turn){
        return true
    }
    return false
}

fun inputCheck(row : Int, col : Int) : Boolean {
    if(row > 2 || col > 2){
        return false
    }else if (row < 0 || col < 0){
        return false
    }
    return true
}

fun printArray(arrayOX : Array<Array<String>> ) {
    println("- 1  2  3")
    for (i in arrayOX.indices ) {
        print(i+1)
        for (j in arrayOX[i].indices){
            print(" ${arrayOX[i][j]} ")
        }
        println()
    }
    println("---------")
}

fun arrayisEmpty(StringIndex : String) : Boolean {
    return StringIndex == "-"
}