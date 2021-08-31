void create_s3_bucket(){
  sh "aws s3 mb s3://linux-is-awesome --region eu-central-1"
  
  sh "aws s3 website s3://linux-is-cool --index-document index.html --error-document error.html"
}
void copy_s3_bucket(){
 sh "sh "aws s3 cp new.txt s3://linux-is-awesome"" 
}

