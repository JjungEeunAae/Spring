<template>
<div>
    <h2>회원가입</h2>
    <input><br>
    <input><br>
    <input><br>
    <input><br>
    <button @click="register" type="button">등록</button>
</div>
</template>

<script>
module.exports = {
    data: function() {
        return {
            who: 'world'
        }
    },
    methods : {
        register(){
            console.log("가입완료");
            this.$router.push("/login");
        }
    }
}
</script>

<style>
.hello {
    background-color: #ffe;
}
</style>