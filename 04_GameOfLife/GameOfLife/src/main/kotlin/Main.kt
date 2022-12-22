import kotlin.random.Random

val BOARD_SIZE: Int = 15

fun main(args: Array<String>) {
    println("Hello World!")

    val rows = BOARD_SIZE
    val cols = BOARD_SIZE

    var arr = Array(rows) {IntArray(cols)}

    for (row in 0..(arr.size-1)) {
        for (col in 0..(arr[0].size-1)) {
            arr[row][col] = Random.nextInt(0,2)
        }
    }

    for (row in arr) {
        println(row.contentToString())
    }

    while(true){
        var newArr = arr.copyOf()
        for (row in 0..(arr.size-1)) {
            for (col in 0..(arr[0].size-1)) {
                val adjacent = countAdjacent(arr, row, col)
                val alive:Int = 1
                val dead:Int = 0
                if (arr[row][col] == alive){
                    if(adjacent <= 2 || adjacent > 3) {
                        newArr[row][col] = dead
                    }
                } else if(adjacent == 3 || adjacent == 2) {
                    newArr[row][col] = alive
                }
            }
        }
        arr = newArr.copyOf()
        Thread.sleep(1000)
        println("*****************************")
        for (row in newArr) {
            println(row.contentToString())
        }
    }



    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun countAdjacent(board: Array<IntArray>, row:Int, col:Int):Int {
    var adjacent:Int = 0
    val alive:Int = 1
    if(row > 0 && board[row-1][col] == alive) {
        adjacent += 1
    }
    if(row < (BOARD_SIZE-1) && board[row+1][col] == alive) {
        adjacent += 1
    }
    if(col > 0 && board[row][col-1] == alive) {
        adjacent += 1
    }
    if(col < (BOARD_SIZE-1) && board[row][col+1] == alive) {
        adjacent += 1
    }
    return adjacent
}