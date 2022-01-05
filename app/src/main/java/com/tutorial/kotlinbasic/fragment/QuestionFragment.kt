package com.tutorial.kotlinbasic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tutorial.kotlinbasic.R
import kotlinx.android.synthetic.main.fragment_question.* // fragment_main과 혼동 주의

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
// 상속은 하나만 받을 수 있지만, 인터페이스는 여러 개를 받아서 구현할 수 있다.
class QuestionFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        btn_next.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // 버튼이 여러 개 생기면, 버튼마다 하나하나 setOnClickListener를 써주는 게 번거로우니까
        // OnClickListener 인터페이스의 onClick 메소드를 구현하여 클릭 이벤트를 한 곳에서 처리한다.
        when(v?.id){
            R.id.btn_next -> {
                navController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }
        }
    }
}