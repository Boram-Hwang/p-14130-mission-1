package com

data class WiseSaying(
    val id: Int,
    val content: String?,
    val author: String?,
)

fun main() {
    println("== 명언 앱 ==")
    var index = 1;
    val wiseSayings = mutableListOf<WiseSaying>()

    while(true) {
        print("명령) ")
        val text = readlnOrNull()?.trim()

        if(text.equals("종료")) {
            break;
        } else if(text.equals("등록")) {
            print("명언 : ")
            val content = readlnOrNull()?.trim()
            print("작가 : ")
            val author = readlnOrNull()?.trim()

            // wiseSaying 클래스의 객체 생성
            val wiseSaying = WiseSaying(
                id = index,
                content = content,
                author = author
            )

            wiseSayings.add(wiseSaying)

            println("${index}번 명언이 등록되었습니다.")
            index++;
        } else if(text.equals("목록")) {
            println("번호 / 작가 / 명언")
            println("----------------------")
            for (wiseSaying in wiseSayings.reversed()) {
                println(
                    "${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.content}"
                )
            }
        } else if(text?.startsWith("삭제?id=") == true) {
            val id = text.split('=')[1].toInt()

            val target = wiseSayings.find { it.id == id }

            if(target == null) {
                println("${id}번 명언은 존재하지 않습니다.")
            } else {
                wiseSayings.removeIf { it.id == target.id }
                println("${id}번 명언이 삭제되었습니다.")
            }
        }
    }
}