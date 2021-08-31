def create_lambda_function(){
  sh """aws lambda create-function \
    --function-name my-function \
    --runtime nodejs10.x \
    --zip-file fileb://my-function.zip \
    --handler my-function.handler \
    --role arn:aws:iam::123456789012:role/service-role/MyTestFunction-role-tges6bf4
  """
}
