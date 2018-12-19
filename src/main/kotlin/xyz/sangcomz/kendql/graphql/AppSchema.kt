package xyz.sangcomz.kendql.graphql

import com.github.pgutkowski.kgraphql.KGraphQL
import xyz.sangcomz.kendql.model.KendQLData

class AppSchema() {

    val schema = KGraphQL.schema {

        type<KendQLData> {
            description = "A KendQL Data"
        }

        query("allUser") {
            description = "get all KendQL Data"

            resolver { -> arrayListOf<KendQLData>(KendQLData("sangcomz", "desdes")) }
        }
    }
}