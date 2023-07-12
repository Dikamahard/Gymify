<?php

return [

    /*
    |--------------------------------------------------------------------------
    | Default Filesystem Disk
    |--------------------------------------------------------------------------
    |
    | Here you may specify the default filesystem disk that should be used
    | by the framework. The "local" disk, as well as a variety of cloud
    | based disks are available to your application. Just store away!
    |
    */

    'default' => env('FILESYSTEM_DISK', 'local'),

    /*
    |--------------------------------------------------------------------------
    | Filesystem Disks
    |--------------------------------------------------------------------------
    |
    | Here you may configure as many filesystem "disks" as you wish, and you
    | may even configure multiple disks of the same driver. Defaults have
    | been set up for each driver as an example of the required values.
    |
    | Supported Drivers: "local", "ftp", "sftp", "s3"
    |
    */

    'disks' => [

        'local' => [
            'driver' => 'local',
            'root' => storage_path('app'),
            'throw' => false,
        ],

        'public' => [
            'driver' => 'local',
            'root' => storage_path('app/public'),
            'url' => env('APP_URL').'/storage',
            'visibility' => 'public',
            'throw' => false,
        ],

        's3' => [
            'driver' => 's3',
            'key' => env('AWS_ACCESS_KEY_ID'),
            'secret' => env('AWS_SECRET_ACCESS_KEY'),
            'region' => env('AWS_DEFAULT_REGION'),
            'bucket' => env('AWS_BUCKET'),
            'url' => env('AWS_URL'),
            'endpoint' => env('AWS_ENDPOINT'),
            'use_path_style_endpoint' => env('AWS_USE_PATH_STYLE_ENDPOINT', false),
            'throw' => false,
        ],

        'gcs' => [
            'driver' => 'gcs',
            'key_file_path' => env('GOOGLE_CLOUD_KEY_FILE', null), // optional: /path/to/service-account.json
            'key_file' => [
                "type"=> "service_account",
                "project_id" => "gymify-backend",
                "private_key_id" => "aad26f82dbb2176bb68cdfdf86bc88ecf67754ad",
                "private_key" => "-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCffSswXgZzN8wg\n7PCAPyXN721bwUaeOPssa7DWF05TUZd2bw7ADN0j04gVLc7x9dbDkV/RWs4TwDke\nKFHk88WxdBkCwWUsp/l/qZJ1Z9oWhaFfM4y0F58T+fxWB1vCHtv9/6eBVn5s/TaF\nH+SlDuTKEglluu5g8sO3Pi929mfvptD0q9hjdNAnl7B3Vcof2JBAl0h+hDEZJ33Y\nZbc444EcGGufWkQ6FlPqkAkegTdrTy5axMswV16I7laqiwTbktzQh8UedRwUZ5vv\nBkXQh2ymaodoN7tC1HkY/yU+kJhvZcQQLQ4KArtQGDVSsT2tTUi/YTwNcThUs8V1\nR6HJXdf7AgMBAAECggEAM5badI/FiFmBJxldhi5m/SE4f5iaTi3iWXEQR4BMbrkS\nxFWSMN84XRFckHU73pqF+Ma6ds7noA3qq+2g5+1OgmMqf/Cs2HARTZE9dcq9CdH5\n7ACRv+NwKpcPX4iLztQKlzOuLDEdPgX+L7usSxPxP8fr0ENSPnvogQqVceasoiER\nO93wY+vPf89I4Qp2GWdb+OX3fN86aBkUSfAV9DSsoC9uQD92yG6dJ7rWULbrPFQo\nYXXi1Lu9E1b+mT4lLTpALS75uKYF2LvsG2TEDb9fTnOHrRNIfauBk+FeNULkykPs\nqhlgYAQVn6a/kOjDJN4ken3XDTRV/ExUupmeSJjYGQKBgQDgm704pUsUZVkYm7Zw\nvv0TdtLZoFK+iF7v8qbq+iE3iue0ujmEju/DgsiDNrDdLZpoYQuJ3ohTndbE9buu\nr4UsUAG9z6iBk0wMJX14wNYjJDHmIn5kgcUZIMHWRGTPtxZZr3DWLxXlM65huMWI\n/ab7b7voPB5ebsB5V/yga93c3QKBgQC1x4W9j20jBoyYmkl2b1fUdQS1jQurmMWa\nYkTX29k73+a4IXOBZMdcjwz++Sb5fBxBppz1HL1gsYlsPljXZ8bDEdtb569ciHPj\nQ93AJVPg2QaY7r2hkNcobWPLNTvVHsE1fAnlyzJThhxIn0pktgKegLT4reNKV7od\n77zrh3ZutwKBgQCQQRYPSoHk8I5/coqC8PcDSD51TTW3b0hiHVs88TbiQFE+Tphg\nXZj53YZAV6DR/Nb9kM5jVswBwA7O4vAOamZCpoPnz3Xu+pZN+soSAu/FFBsELkU0\n8e+Piu1TWwvQKEuvgDEdLpKGaWHnG0+rAxX6yLFLn0j153WwuWTj90M/9QKBgQCN\nTYuoztUHZQ/lkAmLBwI/JLeEaR+pRBhW6gyZv0wePu4aM+aVrsFKMejoSsUBKnjM\nj7dy0eRkRZ2NhumIiCL5f+gEiRTH2Uo8X4UA2ANbxVhbiTnfXbfitSXd0IOyJzYJ\nXWJUPp/gTV+vFCPAJbvjeikzJfiI0ajbnIA+lg56AQKBgHuOiLPBPRNYbyVy43Gn\nKdSHKApRgE95Yy7Y++AdJTNG8Ha7gZGpVjdA/ipZipFj2Sy4yXLGHOTM7wjzRh7N\nC08Cc1Q2y7MPwzwPBdEG2nuINECWmtCdskPibPTJLTjK++aMv8XtOo8lhsbm8GJU\nREI/BVrO9y6MbG6GPqS0yNBN\n-----END PRIVATE KEY-----\n",
                "client_email" => "gymify-image-uploader@gymify-backend.iam.gserviceaccount.com",
                "client_id" => "114481260245503595561",
                "auth_uri" => "https://accounts.google.com/o/oauth2/auth",
                "token_uri" => "https://oauth2.googleapis.com/token",
                "auth_provider_x509_cert_url" => "https://www.googleapis.com/oauth2/v1/certs",
                "client_x509_cert_url" => "https://www.googleapis.com/robot/v1/metadata/x509/gymify-image-uploader%40gymify-backend.iam.gserviceaccount.com",
                "universe_domain" => "googleapis.com"
            ], // optional: Array of data that substitutes the .json file (see below)
            'project_id' => env('GOOGLE_CLOUD_PROJECT_ID', 'Gymify-Backend'), // optional: is included in key file
            'bucket' => env('GOOGLE_CLOUD_STORAGE_BUCKET', 'gymify-backend.appspot.com'),
            'path_prefix' => env('GOOGLE_CLOUD_STORAGE_PATH_PREFIX', ''), // optional: /default/path/to/apply/in/bucket
            'storage_api_uri' => env('GOOGLE_CLOUD_STORAGE_API_URI', null), // see: Public URLs below
            'apiEndpoint' => env('GOOGLE_CLOUD_STORAGE_API_ENDPOINT', null), // set storageClient apiEndpoint
            'visibility' => 'public', // optional: public|private
            'visibility_handler' => null, // optional: set to \League\Flysystem\GoogleCloudStorage\UniformBucketLevelAccessVisibility::class to enable uniform bucket level access
            'metadata' => ['cacheControl'=> 'public,max-age=86400'], // optional: default metadata
        ],
    ],

    /*
    |--------------------------------------------------------------------------
    | Symbolic Links
    |--------------------------------------------------------------------------
    |
    | Here you may configure the symbolic links that will be created when the
    | `storage:link` Artisan command is executed. The array keys should be
    | the locations of the links and the values should be their targets.
    |
    */

    'links' => [
        public_path('storage') => storage_path('app/public'),
    ],

];
