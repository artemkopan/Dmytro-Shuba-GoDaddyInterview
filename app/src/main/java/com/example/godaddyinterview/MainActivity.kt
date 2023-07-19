package com.example.godaddyinterview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.godaddyinterview.interview.MainGrid
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
                MainGrid()
            }
        }
    }





























































    @Composable
    fun generateUI(uiString: String) {

    }

    fun parseComposableCode(code: String): ViewData {
        val packageNameRegex = Regex("package\\s+(\\S+)\\s*")
        val importRegex = Regex("import\\s+(\\S+)\\s*")
        val classRegex = Regex("@Composable\\s*fun\\s+(\\S+)\\s*\\(")
        val parameterRegex = Regex("(\\w+)\\s*=\\s*([^,)]+)")
        val packageName = packageNameRegex.find(code)?.groupValues?.get(1) ?: ""
        val importStatements = importRegex.findAll(code).mapNotNull {
            it.groupValues.getOrNull(1)
        }.toList()
        val className = classRegex.find(code)?.groupValues?.get(1) ?: ""
        val parameters = parameterRegex.findAll(code).associate {
            it.groupValues[1] to it.groupValues[2]
        }
        return ViewData(className, parameters, importStatements, packageName)
    }

    fun createView(viewData: ViewData, context: Context): View {
        val clazz = Class.forName(viewData.className)
        val constructor = clazz.declaredConstructors.first()
        val parameterTypes = constructor.parameterTypes
        val arguments = arrayOfNulls<Any>(parameterTypes.size)

        for ((index, parameterType) in parameterTypes.withIndex()) {
            val parameterName = parameterType.simpleName
            val parameterValue = viewData.viewParams[parameterName]
            if (parameterValue != null) {
                arguments[index] = when (parameterType) {
                    String::class.java -> parameterValue
                    Int::class.java -> parameterValue.toInt()
                    else -> null
                }
            }
        }

        val view = constructor.newInstance(*arguments) as View
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return view
    }

    fun showView(view: View) {
        runOnUiThread {
            val viewGroup = findViewById<ViewGroup>(android.R.id.content)
            viewGroup.addView(view)
        }
    }

}
data class ViewData(
    val className: String,
    val viewParams: Map<String, String>,
    val imports: List<String>,
    val packageName: String
)

private val API_RESPONSE = """
        @Composable
        fun renderButton(buttonData: ButtonData) {
            Button(onClick = {
                //your onclick code here
            }) {
                Text(text = buttonData.text)
            }
        }
    """.trimIndent()