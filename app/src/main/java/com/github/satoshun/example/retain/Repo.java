package com.github.satoshun.example.retain;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@AutoValue
public abstract class Repo implements Parcelable {

    @SerializedName("id")
    public abstract int id();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("full_name")
    public abstract String fullName();

    @SerializedName("owner")
    public abstract Owner owner();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("html_url")
    public abstract String htmlUrl();

    @SerializedName("events_url")
    public abstract String eventsUrl();

    @SerializedName("private")
    public abstract boolean pri();

    @Nullable
    @SerializedName("description")
    public abstract String description();

    @SerializedName("fork")
    public abstract boolean fork();

    @SerializedName("forks_url")
    public abstract String forksUrl();

    @SerializedName("keys_url")
    public abstract String keysUrl();

    @SerializedName("collaborators_url")
    public abstract String collaboratorsUrl();

    @SerializedName("teams_url")
    public abstract String teamsUrl();

    @SerializedName("hooks_url")
    public abstract String hooksUrl();

    @SerializedName("issue_events_url")
    public abstract String issueEventsUrl();

    @SerializedName("assignees_url")
    public abstract String assigneesUrl();

    @SerializedName("branches_url")
    public abstract String branchesUrl();

    @SerializedName("tags_url")
    public abstract String tagsUrl();

    @SerializedName("blobs_url")
    public abstract String blobsUrl();

    @SerializedName("git_tags_url")
    public abstract String gitTagsUrl();

    @SerializedName("git_refs_url")
    public abstract String gitRefsUrl();

    @SerializedName("trees_url")
    public abstract String treesUrl();

    @SerializedName("statuses_url")
    public abstract String statusesUrl();

    @SerializedName("languages_url")
    public abstract String languagesUrl();

    @SerializedName("stargazers_url")
    public abstract String stargazersUrl();

    @SerializedName("contributors_url")
    public abstract String contributorsUrl();

    @SerializedName("subscribers_url")
    public abstract String subscribersUrl();

    @SerializedName("subscription_url")
    public abstract String subscriptionUrl();

    @SerializedName("commits_url")
    public abstract String commitsUrl();

    @SerializedName("git_commits_url")
    public abstract String gitCommitsUrl();

    @SerializedName("comments_url")
    public abstract String commentsUrl();

    @SerializedName("issue_comment_url")
    public abstract String issueCommentUrl();

    @SerializedName("contents_url")
    public abstract String contentsUrl();

    @SerializedName("compare_url")
    public abstract String compareUrl();

    @SerializedName("merges_url")
    public abstract String mergesUrl();

    @SerializedName("archive_url")
    public abstract String archiveUrl();

    @SerializedName("downloads_url")
    public abstract String downloadsUrl();

    @SerializedName("issues_url")
    public abstract String issuesUrl();

    @SerializedName("pulls_url")
    public abstract String pullsUrl();

    @SerializedName("milestones_url")
    public abstract String milestonesUrl();

    @SerializedName("notifications_url")
    public abstract String notificationsUrl();

    @SerializedName("labels_url")
    public abstract String labelsUrl();

    @SerializedName("releases_url")
    public abstract String releasesUrl();

    @SerializedName("deployments_url")
    public abstract String deploymentsUrl();

    @SerializedName("created_at")
    public abstract Date createdAt();

    @SerializedName("updated_at")
    public abstract Date updatedAt();

    @SerializedName("pushed_at")
    public abstract Date pushedAt();

    @SerializedName("git_url")
    public abstract String gitUrl();

    @SerializedName("ssh_url")
    public abstract String sshUrl();

    @SerializedName("clone_url")
    public abstract String cloneUrl();

    @SerializedName("svn_url")
    public abstract String svnUrl();

    @Nullable
    @SerializedName("homepage")
    public abstract String homepage();

    @SerializedName("size")
    public abstract int size();

    @SerializedName("stargazers_count")
    public abstract int stargazersCount();

    @SerializedName("watchers_count")
    public abstract int watchersCount();

    @Nullable
    @SerializedName("language")
    public abstract String language();

    @SerializedName("has_issues")
    public abstract boolean hasIssues();

    @SerializedName("has_downloads")
    public abstract boolean hasDownloads();

    @SerializedName("has_wiki")
    public abstract boolean hasWiki();

    @SerializedName("has_pages")
    public abstract boolean hasPages();

    @SerializedName("forks_count")
    public abstract int forksCount();

    @Nullable
    @SerializedName("mirror_url")
    public abstract String mirrorUrl();

    @SerializedName("open_issues_count")
    public abstract int openIssuesCount();

    @SerializedName("forks")
    public abstract int forks();

    @SerializedName("open_issues")
    public abstract int openIssues();

    @SerializedName("watchers")
    public abstract int watchers();

    @SerializedName("default_branch")
    public abstract String defaultBranch();

    public static TypeAdapter<Repo> typeAdapter(Gson gson) {
        return new AutoValue_Repo.GsonTypeAdapter(gson);
    }

    @AutoValue
    public static abstract class Owner implements Parcelable {
        @SerializedName("id")
        abstract int id();

        @SerializedName("login")
        abstract String login();

        @SerializedName("avatar_url")
        abstract String avatarUrl();

        @SerializedName("gravatar_id")
        abstract String gravatarId();

        @SerializedName("url")
        abstract String url();

        @SerializedName("html_url")
        abstract String htmlUrl();

        @SerializedName("followers_url")
        abstract String followersUrl();

        @SerializedName("following_url")
        abstract String followingUrl();

        @SerializedName("gists_url")
        abstract String gistsUrl();

        @SerializedName("starred_url")
        abstract String starredUrl();

        @SerializedName("subscriptions_url")
        abstract String subscriptionsUrl();

        @SerializedName("organizations_url")
        abstract String organizationsUrl();

        @SerializedName("repos_url")
        abstract String reposUrl();

        @SerializedName("events_url")
        abstract String eventsUrl();

        @SerializedName("received_events_url")
        abstract String receivedEventsUrl();

        @SerializedName("type")
        abstract String type();

        @SerializedName("site_admin")
        abstract boolean siteAdmin();

        public static TypeAdapter<Owner> typeAdapter(Gson gson) {
            return new AutoValue_Repo_Owner.GsonTypeAdapter(gson);
        }
    }
}
