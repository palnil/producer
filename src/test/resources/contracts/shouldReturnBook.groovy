import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return book"
    request {
        method POST()
        url("/book")
        headers {
            header(contentType(), 'application/json;charset=UTF-8')
        }
        body("id": 1L)
    }
    response {
        status(200)
        headers {
            header(contentType(),'application/json;charset=UTF-8')
        }
        body( "id": 1L, "name": "Harry Porter")
    }
}