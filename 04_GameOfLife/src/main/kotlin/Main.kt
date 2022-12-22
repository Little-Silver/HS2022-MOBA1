import kotlin.random.Random

const val height = 10
const val width = 10
var oldBoard = Array(height) { Array(width) { 0 } }
var newBoard = Array(height) { Array(width) { 0 } }

fun main(args: Array<String>) {
  initBoard(oldBoard)
  printBoard(oldBoard, "Old Board")
  generateNewBoard()
  printBoard(newBoard, "New Board")
}

private fun generateNewBoard() {
  for (i in oldBoard.indices) {
    var j = 0
    while (j < oldBoard[i].size) {
      var countAliveNeighbors = getAliveNeighbors(i, j)

      countAliveNeighbors -= oldBoard[i][j]

      if (oldBoard[i][j] == 1 && countAliveNeighbors < 2) {
        newBoard[i][j] = 0
      } else if (oldBoard[i][j] == 1 && countAliveNeighbors > 3) {
        newBoard[i][j] = 0
      } else if (oldBoard[i][j] == 0 && countAliveNeighbors == 3) {
        newBoard[i][j] = 1
      } else {
        newBoard[i][j] = oldBoard[i][j]
      }
      j++
    }
  }
}

private fun initBoard(board: Array<Array<Int>>) {
  for (i in board.indices) {
    var j = 0
    while (j < board[i].size) {
      board[i][j] = Random.nextInt(0, 2)
      j++
    }
    println()
  }
}

private fun getAliveNeighbors(x: Int, y: Int): Int {
  var countAliveNeighbors = 0

  for (i in x - 1..x + 1) {
    for (j in y - 1..y + 1) {
      if (!((i < 0 || j < 0) || (i >= height || j >= width))) {
        if (oldBoard[i][j] == 1) countAliveNeighbors++
      }
    }
  }
  return countAliveNeighbors
}

private fun printBoard(board: Array<Array<Int>>, title: String) {
  println(title)
  println("-------------------------------------------")

  for (i in board.indices) {
    var j = 0
    while (j < board[i].size) {
      print("|")
      if (board[i][j] == 0) {
        print(" ")
      } else {
        print("#")
      }
      j++
    }
    print("|")
    println()
  }
  println("-------------------------------------------")
  println()
}