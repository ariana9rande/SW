from django.shortcuts import render, redirect, get_object_or_404
from .models import Notice
from django.urls import reverse
from django.utils import timezone

# Create your views here.
def index(request):
    article_list = Notice.objects.all().order_by("-write_date")
    # index 페이지 list 받아오기. -는 desc 표시
    context = {'article_list' : article_list}
    # 받아온 데이터 딕셔너리로 만들기
    return render(request, 'board/index.html', context)
    # index.html을 context와 함께 뿌려줌

def write_article(request):
    return render(request, 'board/write.html')

def add(request):
    notice = Notice()
    notice.title = request.POST['i_title']
    notice.content= request.POST['i_content']
    notice.write_id = 'Hi'
    notice.save()

    return redirect(reverse('board:index'))

def view(request, article_id):
    notice = get_object_or_404(Notice, pk = article_id)
    # get_object_or_404 : 데이터를 가져오는 것에 실패하면 404화면 뿌려줌
    return render(request, 'board/view.html', {'article' : notice})

def update(request, article_id):
    notice = Notice.objects.get(id = article_id)
    
    if request.method == 'POST':
        notice.title = request.POST['title']
        notice.content = request.POST['content']
        notice.write_date = timezone.datetime.now()
        #write_date를 현재시각으로 갱신

        notice.save()
        return redirect(reverse('board:view_article', args=(article_id,)))
    
    else:
        return render(request, 'board/view.html', {'article' : notice})
    
def delete(request, article_id):
    notice = Notice.objects.get(id = article_id)
    notice.delete()
    return redirect(reverse('board:index'))