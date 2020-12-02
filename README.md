# project2-matmaungdung
- Cách khởi chạy
  Trong folder chứa project sử dụng lệnh :
    java -jar target/project2/project2.jar (win, linux)
   hoặc có thể run trực tiếp class common.java trong package com.project2.matmaungdung
  - Sau khi khởi chạy có các lựa chọn từ 1-4 ứng với encrypt, decrypt của CBC và CTR
      1: Aes/cbc encrypt
      2: AES/CBC decrypt
      3: AES/CTR encrypt
      4: AES/CTR decrypt
      Enter type:
   - Sau khi chọn 1-4 thì chương trình yêu cầu absolute path của file cần mã hóa.
    Win:
      Absolute path:
      D:\matmaungdung\all-slides\1. s-intro.pdf
    Linux:
      Absolute path:
      home/Documents/project2.pdf
    - Chương trình yêu cầu nhập Key với độ dài 16 bit(AES_128)
        Key (length 16 bytes):
        1234567890123456
    - Để thoát khỏi chương trình tại bất cứ đâu, nhập "exit"
    - File được mã hóa cùng folder chứa file gốc và thêm đuôi -encrypted hoặc -decrypted sau tên.
  
 
