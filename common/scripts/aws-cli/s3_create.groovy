aws s3 mb s3://linux-is-awesome --region eu-central-1
  
  sh "aws s3 website s3://linux-is-cool --index-document index.html --error-document error.html"
