void create_s3_bucket(bucket_details){
  try{
      //step1 : create s3 bucket
      sh "aws s3api create-bucket --bucket my-bucket --region us-east-1"
      //step2: adding tags for billing and tracking
      sh "aws s3api put-bucket-tagging --bucket my-bucket --tagging file://tagging.json"
      //step3: encrypt bucket
      sh """
        aws s3api put-bucket-encryption \
          --bucket my-bucket \
          --server-side-encryption-configuration '{"Rules": [{"ApplyServerSideEncryptionByDefault": {"SSEAlgorithm": "AES256"}}]}'
        """
      //step3: apply bucket policy
     sh "aws s3api put-bucket-policy --bucket MyBucket --policy file://policy.json"

    // policy.json:
    // {
    //    "Statement": [
    //       {
    //          "Effect": "Allow",
    //          "Principal": "*",
    //          "Action": "s3:GetObject",
    //          "Resource": "arn:aws:s3:::MyBucket/*"
    //       },
    //       {
    //          "Effect": "Deny",
    //          "Principal": "*",
    //          "Action": "s3:GetObject",
    //          "Resource": "arn:aws:s3:::MyBucket/MySecretFolder/*"
    //       },
    //       {
    //          "Effect": "Allow",
    //          "Principal": {
    //             "AWS": "arn:aws:iam::123456789012:root"
    //          },
    //          "Action": [
    //             "s3:DeleteObject",
    //             "s3:PutObject"
    //          ],
    //          "Resource": "arn:aws:s3:::MyBucket/*"
    //       }
    //    ]
    // }

      //step 4: 
      sh "aws s3api put-bucket-cors --bucket MyBucket --cors-configuration file://cors.json"
    // cors.json:
    // {
    //   "CORSRules": [
    //     {
    //       "AllowedOrigins": ["http://www.example.com"],
    //       "AllowedHeaders": ["*"],
    //       "AllowedMethods": ["PUT", "POST", "DELETE"],
    //       "MaxAgeSeconds": 3000,
    //       "ExposeHeaders": ["x-amz-server-side-encryption"]
    //     },
    //     {
    //       "AllowedOrigins": ["*"],
    //       "AllowedHeaders": ["Authorization"],
    //       "AllowedMethods": ["GET"],
    //       "MaxAgeSeconds": 3000
    //     }
    //   ]
    // }
  }catch(Exception e){
  }
}
void copy_s3_bucket(){
 sh "sh "aws s3 cp new.txt s3://linux-is-awesome"" 
}

void delete_s3_ducket(){
  sh "aws s3 rm s3://linux-is-awesome/delete-me"
}
