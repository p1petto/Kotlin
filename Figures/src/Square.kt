class Square(var x: Int, var y: Int, var side: Int): Transforming, Movable, Figure(0){
    override fun area(): Float {
        return (side * side).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun resize(zoom: Int) {
        side *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int){
        when (direction){
            RotateDirection.Clockwise ->{
                // -(3,3)
                x -= centerX
                y -= centerY
                //swap
                var temp = y
                y = -x
                x = temp
                x += centerX
                y += centerY
            }
            RotateDirection.CounterClockwise ->{
                // -(3,3)
                x -= centerX
                y -= centerY
                //swap
                var temp = y
                y = x
                x = -temp
                x += centerX
                y += centerY
            }
        }
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }
}