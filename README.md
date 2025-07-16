# 📝 Blog API - Nền tảng chia sẻ bài viết cá nhân

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21-blue)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen)](https://spring.io/projects/spring-boot)

## 🚀 Giới thiệu
Đây là một dự án backend RESTful API giúp người dùng quản lý các bài viết blog cá nhân. Dự án được xây dựng bằng **Java Spring Boot**, tuân thủ kiến trúc 3 lớp (Controller - Service - Repository), hỗ trợ đầy đủ các thao tác **CRUD**, xử lý lỗi tập trung và cấu trúc code theo chuẩn thực tế.

## 🧩 Tính năng

- 📄 Tạo bài viết mới
- 📚 Lấy danh sách bài viết (hỗ trợ lọc theo `tag`, `ngày xuất bản`)
- 🔍 Xem chi tiết bài viết theo `ID`
- ✏️ Cập nhật nội dung bài viết
- 🗑️ Xoá bài viết
- ✅ Kiểm tra dữ liệu đầu vào bằng Validation
- ⚠️ Trả lỗi chi tiết nếu dữ liệu không hợp lệ (Validation + Global Exception Handling)

## 🛠️ Công nghệ sử dụng

| Công nghệ | Mô tả |
|----------|-------|
| Java 17 | Ngôn ngữ lập trình chính |
| Spring Boot | Framework backend chính |
| Spring Web | Xây dựng RESTful API |
| Spring Validation (Jakarta) | Kiểm tra dữ liệu đầu vào |
| ModelMapper | Mapping giữa Entity và DTO |
| Lombok | Giảm boilerplate code |
| MySQL | Cơ sở dữ liệu chính |
| Postman | Kiểm thử API thủ công |

## 🏗 Kiến trúc tổng thể

- Kiến trúc theo mô hình phân tầng: Controller -> Service -> Repository
- Áp dụng nguyên tắc SOLID, clean code và phân tách rõ ràng DTO, Entity, Mapper.

## 📁 Cấu trúc thư mục chính
```bash
src/
├── controller/ # Xử lý các request từ client
├── dto/ # Định nghĩa các request/response DTO
├── entity/ # Entity ánh xạ với bảng DB
├── repository/ # Interface thao tác với DB
├── service/ # Business logic chính
│ └── impl/ # Implement của service
├── exception/ # Xử lý lỗi tập trung
├── config/ # Cấu hình ứng dụng (ModelMapper, ...)
```

## ▶️ Hướng dẫn chạy dự án
### 1. Yêu cầu hệ thống
- Java 17 trở lên
- Maven 3.8+
- MySQL 8+
- Docker (tuỳ chọn)

### 2. Cài đặt
#### Chạy bằng IntelliJ
```bash
1. Clone repo:
   git clone https://github.com/Anh-Tuan-Bui/blog-api.git
2. Mở project trong IntelliJ
3. Cấu hình file src/main/resources/application.yml theo MySQL của bạn
4. Chạy file BlogApiApplication.java
```

#### Chạy thủ công
```bash
# Clone repository
git clone https://github.com/Anh-Tuan-Bui/blog-api.git
cd blog-api

# Cấu hình file src/main/resources/application.yml theo MySQL của bạn

# Build & chạy
./mvnw spring-boot:run
```

#### Hoặc chạy bằng Docker
```bash
# Tạo file .env nếu cần
docker-compose up --build
```

#### 🌐 Truy cập API
API Base URL: http://localhost:8080/api/articles

## 🔄 API mẫu (Sử dụng với Postman)
### 1. Tạo bài viết mới
```http
POST /api/articles
Content-Type: application/json

{
  "title": "Spring Boot là gì?",
  "content": "Đây là bài viết giới thiệu về Spring Boot...",
  "author": "Tuan Anh",
  "tag": "java"
}
```

### 2. Lấy danh sách bài viết
```http
GET /api/articles?tag=java&dateAfter=2024-01-01
```

### 3. Cập nhật bài viết
```http
PUT /api/articles/{id}
{
  "title": "Spring Boot cơ bản",
  "content": "Nội dung cập nhật...",
  "author": "Tuan Anh",
  "tag": "backend"
}
```

### 4. Xoá bài viết
```http
DELETE /api/articles/{id}
```

## ⚠️ Xử lý lỗi
Dự án có GlobalExceptionHandler xử lý tập trung các lỗi như:
- NotFoundException → trả về 404 kèm thông báo rõ ràng
- MethodArgumentNotValidException → trả về 400 cùng danh sách lỗi chi tiết

## 🧪 Kiểm thử API
- Sử dụng Postman Collection
- Kiểm thử các case: CRUD bài viết, tìm kiếm...

## 📌 Kế hoạch phát triển tiếp theo
 - Giao diện frontend bằng VueJS hoặc ReactJS
 - Tính năng comment cho bài viết
 - Like / dislike bài viết
 - Thống kê số lượng bài viết theo thời gian

## 📄 License
Dự án sử dụng giấy phép MIT – tự do sử dụng cho mục đích học tập & cá nhân.