package org.techtown.fragmentapplication3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import org.techtown.fragmentapplication3.databinding.FragmentReceiverBinding

class ReceiverFragment : Fragment() { //수신 측 코드
    lateinit var binding : FragmentReceiverBinding //프래그먼트는 바인딩 생성 시 onCreateView()메서드 안에서만 사용할 수 있는 파라미터가 필요함.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiverBinding.inflate(inflater,container,false) //binding프로퍼티에 바인딩을 저장했기 때문에 다른 메서드에서도 가져다가 쓸 수 있습니다.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request"){key,bundle->  //통신을 위한 프래그먼트,request는 요청 전체에 대한 키이고,bundle.getString에 입력되는 valueKey는 요청에 담겨 있는 여러 개의 값중에 하나의 값을 가리키는 키 입니다.
            bundle.getString("valueKey")?.let{
                binding.textView.setText(it)
            }
        }
    }
}