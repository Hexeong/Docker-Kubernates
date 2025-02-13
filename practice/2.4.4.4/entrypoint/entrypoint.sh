echo $1 $2
echo "ServerName localhost" >> /etc/apache2/apache2.conf
apachectl -DFOREGROUND