resource "aws_ecr_repository" "kunlaquota" {
  name                 = "kunlaquota-repo"
  image_tag_mutability = "MUTABLE"
  image_scanning_configuration {
    scan_on_push = false
  }

  tags = {
    Owner: "TimS"
    Name: "tims-kunlaquota-ecr"
  }
}