def create_lambda_function(){
  sh """aws lambda create-function \
    --function-name my-function \
    --runtime nodejs10.x \
    --zip-file fileb://my-function.zip \
    --handler my-function.handler \
    --role arn:aws:iam::123456789012:role/service-role/MyTestFunction-role-tges6bf4
  """
}

def update_lambda_function_env_variables(){
  sh """
    aws lambda update-function-configuration \
      --function-name  my-function \
      --memory-size 256
    """
}

def update_lambda_function_code(){
  sh """
    aws lambda update-function-code \
        --function-name  my-function \
        --zip-file fileb://my-function.zip
      """
}

def publish_version(){
 sh """ 
 aws lambda publish-version \
    --function-name my-function
    """
}
